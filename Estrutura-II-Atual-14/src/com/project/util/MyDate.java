package com.project.util;


/* Classe para manipular datas.
 * Programado por Raimundo Machado Costa
 */

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class MyDate implements Comparable<MyDate>, Serializable {
	private final Calendar data;

	// Inicializa com a data corrente.
	public MyDate() {
		data = Calendar.getInstance();
		data.setLenient(false);
	}

	public MyDate(int day, int month, int year) {
		this();
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	public MyDate(String data){
		this();
		setDate(data);
	}

	public void setDay(int day) {
		data.set(Calendar.DATE, day);
	}

	public void setMonth(int month) {
		data.set(Calendar.MONTH, month-1);
	}

	public void setYear(int year) {
		data.set(Calendar.YEAR, year);
	}

	public void setDate(int day, int month, int year) {
		setDay(day); getDay();
		setMonth(month); getMonth();
		setYear(year); getYear();
	}
	
	public void setDate(String data) {
		int day = Integer.valueOf(data.substring(0, 2));
		int month = Integer.valueOf(data.substring(3, 5));
		int year = Integer.valueOf(data.substring(6));
		setDay(day); getDay();
		setMonth(month); getMonth();
		setYear(year); getYear();
	}

	public int getDay() {
		return data.get(Calendar.DAY_OF_MONTH);
	}

	public int getMonth() {
		return data.get(Calendar.MONTH) + 1	;
	}

	public int getYear() {
		return data.get(Calendar.YEAR);
	}

	public String getDate() {
		String dataS = String.format("%02d/%02d/%04d", getDay(), getMonth(),
				getYear());
		return dataS;
	}
	
	public Date toDate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dtRetorno = null;
		try {
			dtRetorno = formato.parse(String.format("%02d/%02d/%04d", this.getDay(), this.getMonth(), this.getYear()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtRetorno;
	}
	
	@Override
	public String toString(){
		return getDate();
	}

	@Override
	public int compareTo(MyDate data1) {
		return this.data.compareTo(data1.data);
	}

}
