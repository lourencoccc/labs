/*
 ============================================================================
 Name        : pocdefinitions.c
 Author      : lourenco
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include "pocdefinitions.h"

// Days number extraction macro
int getDays(int timestamp)
{
	return timestamp /ADL_RTC_DAY_SECONDS;
}

// Hours number extraction macro
int getHours(int timestamp)
{
	return ((timestamp % (ADL_RTC_DAY_SECONDS)) / (ADL_RTC_HOUR_SECONDS) );
}

// Minutes number extraction macro
int getMinutes(int timestamp)
{
	return ( ( timestamp % ADL_RTC_HOUR_SECONDS ) / ADL_RTC_MINUTE_SECONDS );
}

// Seconds number extraction macro
int getSeconds(int timestamp)
{
	return (timestamp % ADL_RTC_MINUTE_SECONDS);
}

//// Milliseconds number extraction macro
//#define ADL_RTC_GET_TIMESTAMP_MS(_t)        ( ((u32)( _t.SecondFracPart * ADL_RTC_SECOND_FRACPART_STEP )) / ADL_RTC_MS_US )
//
//// Seconds number extraction macro
//#define ADL_RTC_GET_TIMESTAMP_US(_t)        ( ((u32)( _t.SecondFracPart * ADL_RTC_SECOND_FRACPART_STEP )) % ADL_RTC_MS_US )

