package com.separator.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class ThousandFormatterService {

public String thousandFormatter(BigDecimal number) {
		
		int c = number.compareTo(BigDecimal.ONE);
		BigDecimal one = BigDecimal.ONE;
		BigDecimal oneminus = one.negate();
		int cminus = number.compareTo(oneminus);
		int z = number.compareTo(BigDecimal.ZERO);
		boolean flag = false;
		
		if((c == -1 && z == 1) || (z == -1 && cminus == 1)) {
			String str = "";
			if(z == -1) {
				number = number.multiply(new BigDecimal("-1"));
				flag = true;
			}
			str = number.toString();

			if(str.contains("E")) {
				int index = str.indexOf('-');
				index++;
				String zerosCount = "" ;
				while(index < str.length()) {
					zerosCount += str.charAt(index);
					index++;
				}
				
				int zerosCountint = Integer.parseInt(zerosCount);
				zerosCountint--;
				
				String ans = "0.";
				while(zerosCountint > 0) {
					ans += '0';
					zerosCountint--;
				}
				
				int Eindex = str.indexOf('E');
				String temp = "";
				for(int i = 0; i < Eindex; i++) {
					if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
						temp += str.charAt(i);
					}
				}
				ans+=temp;
				if(flag == true) 
					return "-"+ans;
				else 
					return ans;
			}
			else {
				if(flag)
					return "-" + number.toString();
				return number.toString();
			}
			
		}
		
		else {
			NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
			DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
			
			String numberString = number.toString();
			int decimalIndex = numberString.indexOf(".");
			int n = numberString.length();
			int afterDecimal = n - decimalIndex - 1;
			String formatter = "#,##0";
			if(decimalIndex != -1) {
				formatter += '.';
				while(afterDecimal > 0) {
					formatter += '0';
					afterDecimal--;
				}
			}

			decimalFormat.applyPattern(formatter);
			return decimalFormat.format(number);
		}

	}
	
}
