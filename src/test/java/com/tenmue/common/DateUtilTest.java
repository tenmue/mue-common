package com.tenmue.common;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	/**
	 * formatDate testCase
	 */
	
	@Test
	public void testFormatDate() {
		String str = DateUtil.formatDate(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(str);
		Assert.assertNotNull(str);
	}
	
	@Test
	public void testFormatDateIsDateNull() {
		String str = DateUtil.formatDate(null, DateUtil.YYYY_MM_DD_HH);
		System.out.println(str);
		Assert.assertNull(str);
	}
	
	@Test
	public void testFormatDateIsPatternNull() {
		String str = DateUtil.formatDate(new Date(), null);
		System.out.println(str);
		Assert.assertNull(str);
	}
	
	@Test
	public void testFormatDateIsParamsNull() {
		String str = DateUtil.formatDate(null, null);
		System.out.println(str);
		Assert.assertNull(str);
	}
	
	@Test
	public void testFormatDate2() {
		String str = DateUtil.formatDate(null);
		System.out.println(str);
		Assert.assertNull(str);
	}
	
	@Test
	public void testFormatDate3() {
		String str = DateUtil.formatDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(str);
		Assert.assertNotNull(str);
	}
	
	
	/**
	 * parseDate testCase
	 */

	@Test
	public void testParseDate() {
		Date date = DateUtil.parseDate("2017-12-07 13:10:11", DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(date);
		Assert.assertNotNull(date);
	}
	
	@Test
	public void testParseDate2() {
		Date date = DateUtil.parseDate(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(date);
		Assert.assertNull(date);
	}
	
	@Test
	public void testParseDate3() {
		Date date = DateUtil.parseDate("2017-12-07 13:10:11", null);
		System.out.println(date);
		Assert.assertNull(date);
	}
	
	@Test
	public void testParseDateIsParamsNull() {
		Date date = DateUtil.parseDate(null, null);
		System.out.println(date);
		Assert.assertNull(date);
	}
	
	@Test
	public void testParseDateException() {
		Date date = DateUtil.parseDate("2017/12/07 13:10:11", DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(date);
		Assert.assertNull(date);
	}
	
	@Test
	public void testParseDate4() {
		Date date = DateUtil.parseDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
		System.out.println(date);
		Assert.assertNotNull(date);
	}
	
	@Test
	public void testParseDate5() {
		Date date = DateUtil.parseDate(null);
		System.out.println(date);
		Assert.assertNull(date);
	}
	
	
	/**
	 * between testCase
	 */
	
	@Test
	public void testBetween() {
		Date srcDate = DateUtil.parseDate("2017-12-08 13:10:11", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date startDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-09 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.between(srcDate, startDate, endDate);
		Assert.assertTrue(isFlag);
	}
	
	@Test
	public void testBetween2() {
		Date srcDate = DateUtil.parseDate("2017-12-06 13:10:11", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date startDate = DateUtil.parseDate("2017-12-07 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.between(srcDate, startDate, endDate);
		Assert.assertFalse(isFlag);
	}
	
	@Test
	public void testBetween3() {
		Date srcDate = DateUtil.parseDate("2017-12-06 13:10:11", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date startDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.between(srcDate, startDate, endDate);
		Assert.assertFalse(isFlag);
	}
	
	@Test
	public void testBetween4() {
		Date startDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-05 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.between(startDate, endDate);
		Assert.assertTrue(isFlag);
	}
	
	@Test
	public void testBetween5() {
		Date startDate = DateUtil.parseDate("2017-12-09 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-08 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.between(startDate, endDate);
		Assert.assertFalse(isFlag);
	}
	
	
	/**
	 * equalsDate testCase
	 */
	
	@Test
	public void testEqualsDate() {
		Date startDate = DateUtil.parseDate("2017-12-09 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-09 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.equalsDate(startDate, endDate);
		Assert.assertTrue(isFlag);
	}
	
	@Test
	public void testEqualsDate2() {
		Date startDate = DateUtil.parseDate("2017-12-09 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Date endDate = DateUtil.parseDate("2017-12-08 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		boolean isFlag = DateUtil.equalsDate(startDate, endDate);
		Assert.assertFalse(isFlag);
	}
	
	
	/**
	 * unixToLocalTime testCase
	 */
	
	@Test
	public void testUnixToLocalTime() {
		long unixTime = DateUtil.localToUnixTime("2017-12-07 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		
		String localDate = DateUtil.unixToLocalTime(unixTime, DateUtil.YYYY_MM_DD_HH_MM_SS);
	
		Assert.assertNotNull(localDate);
	}
	
	
	/**
	 * localToUnixTime testCase
	 */
	
	@Test
	public void testLocalToUnixTime() {
		long unixTime = DateUtil.localToUnixTime("2017-12-07 15:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
		Assert.assertNotNull(unixTime);
	}
	
	@Test
	public void testLocalToUnixTime2() {
		long unixTime = DateUtil.localToUnixTime(null, DateUtil.YYYY_MM_DD_HH_MM_SS);
		Assert.assertEquals(unixTime, 0);
	}
	
	@Test
	public void testLocalToUnixTime3() {
		long unixTime = DateUtil.localToUnixTime("2017-12-07 15:00:00", null);
		Assert.assertEquals(unixTime, 0);
	}
	
	@Test
	public void testLocalToUnixTime4() {
		long unixTime = DateUtil.localToUnixTime("2017-12-07 15:00:00", "sssd");
		Assert.assertEquals(unixTime, 0);
	}
	
	@Test
	public void testLocalToUnixTime5() {
		Date date = new Date();
		long unixTime = DateUtil.localToUnixTime(date);
		System.out.println(unixTime);
		Assert.assertNotEquals(unixTime, 0);
	}
	
	@Test
	public void testLocalToUnixTime6() {
		long unixTime = DateUtil.localToUnixTime(null);
		System.out.println(unixTime);
		Assert.assertEquals(unixTime, 0);
	}
	
	
	/**
	 * addYears testCase
	 */
	
	@Test
	public void testAddYears() {
		Date date = DateUtil.addYears(new Date(), 2);
		Assert.assertNotNull(date);
	}
	
	@Test
	public void testAddYears2() {
		Date date = DateUtil.addYears(null, 2);
		Assert.assertNull(date);
	}
	
	@Test
	public void testAddYears3() {
		Date date = DateUtil.addYears(new Date(), 0);
		Assert.assertNull(date);
	}
	
	@Test
	public void testAddYears4() {
		Date date = DateUtil.addYears(null, -1);
		Assert.assertNull(date);
	}

}
