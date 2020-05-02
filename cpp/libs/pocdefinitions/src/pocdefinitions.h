/*
 * pocdefinitions.h
 *
 *  Created on: Feb 5, 2018
 *      Author: joao_lourenco
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#ifndef POCDEFINITIONS_H_
#define POCDEFINITIONS_H_

#define ADL_RTC_DAY_SECONDS     ( 24 * ADL_RTC_HOUR_SECONDS )   // Seconds count in a day
#define ADL_RTC_HOUR_SECONDS    ( 60 * ADL_RTC_MINUTE_SECONDS ) // Seconds count in an hour
#define ADL_RTC_MINUTE_SECONDS  60                              // Seconds count in a minute
#define ADL_RTC_MS_US           1000                            // Seconds count in a millisecond

/*********/
/* Types */
/*********/

// RTC Time Structure
typedef struct
{
	int Year;           // Year (Two digits)
	int Month;          // Month (1-12)
	int Day;            // Day of the month (1-31)
	int Hour;           // Hour (0-23)
	int Minute;         // Minute (0-59)
	int Second;         // Second (0-59)
	int SecondFracPart; // Second fractional part (0-32767)
} adl_rtcTime_t;


// Conversion modes
typedef enum
{
    ADL_RTC_CONVERT_TO_TIMESTAMP,   // RTC Time Structure to TimeStamp conversion
    ADL_RTC_CONVERT_FROM_TIMESTAMP, // TimeStamp to RTC Time Structure conversion

    ADL_RTC_CONVERT_LAST            // Internal use only
} adl_rtcConvert_e;


#endif /* POCDEFINITIONS_H_ */
