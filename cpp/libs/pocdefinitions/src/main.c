/*
 * main.c
 *
 *  Created on: Feb 5, 2018
 *      Author: joao_lourenco
 */

#include "pocdefinitions.h"
#include "buffercirc.h"
#include "selection.h"

void testDates(void)
{
	puts("!!!Hello World!!!\n"); /* prints !!!Hello World!!! */
	time_t now_sec = time(0);
	int timeStamp = now_sec;
	adl_rtcTime_t TimeStructure;
	int Day = (getDays(timeStamp) % 365) / 12;
	int Month = (getDays(timeStamp) / 365) % 12;
	int Year = 1970 + (getDays(timeStamp) / 365);
	int Hour = getHours(timeStamp);
	int Minute = getMinutes(timeStamp);
	int Second = getSeconds(timeStamp);
//	TimeStructure->SecondFracPart = ADL_RTC_GET_TIMESTAMP_DAYS(&TimeStructure);

	adl_rtcConvert_e convert = ADL_RTC_CONVERT_FROM_TIMESTAMP;
	if (ADL_RTC_CONVERT_TO_TIMESTAMP == convert)
	{

		printf("Enum Ok %d\n", ADL_RTC_CONVERT_TO_TIMESTAMP);
	}

	struct tm tstruct;
	char buf[80];
	tstruct = *localtime(&now_sec);
	// Visit http://en.cppreference.com/w/cpp/chrono/c/strftime
	// for more information about date/time format
	strftime(buf, sizeof(buf), "%Y-%m-%d.%X", &tstruct);
	printf("local: %s", buf);
	printf("\nDay %d/%d/%d %d:%d:%d\n", Day, Month, Year, Hour, Minute, Second);
}

void testBufferCirc(void)
{

//	buffer_circ_t buffer;

	CIRCULAR_BUFFER_DECLARE(buffer);

	char vars[] = "012345";
	printf("local: %s\n", vars);

	ald_buffer_insert(&buffer, vars, 4);

	char vars2[2];

	adl_buffer_retrieve(&buffer, vars2, 2);

	adl_buffer_flush(&buffer);

	printf("vars: %s\n", vars2);

	printf("buffer: %s", buffer.data);
}

void testSelection()
{
	int i;
	for(i = 1; i <= 12; i++)
	{
		int vars[4];
		select_med(i, vars);
		printf(" Med: %d Select: %d %d %d %d\n", i, vars[0],vars[1], vars[2],vars[3]);
	}
}

void testBinareOperations()
{
	  unsigned char ENABLED       = 0x01;
	  unsigned char AVAILABLE     = 0x02;
	  unsigned char SWAPPED       = 0x04;
	  unsigned char COMFAIL       = 0x08;

	  unsigned char returnVal;

	  returnVal = AVAILABLE;

	  //returnVal |= SWAPPED;
	  printf(" (returnVal |= SWAPPED) IS  %d\n", returnVal);
	  //(SWAPPED|ENABLED|AVAILABLE)
	  printf(" (SWAPPED|ENABLED|AVAILABLE) IS  %d\n",
			  (SWAPPED|ENABLED|AVAILABLE));
	  //(flags[i+1].serialNumber & (SWAPPED|ENABLED|AVAILABLE)
	  printf(" (returnVal & (SWAPPED|ENABLED|AVAILABLE)) IS  %d\n",
			  (returnVal & (SWAPPED|ENABLED|AVAILABLE)));
	  //(ENABLED|AVAILABLE)
	  printf(" (ENABLED|AVAILABLE) IS  %d\n", (ENABLED|AVAILABLE));
	  //(flags[i+1].serialNumber & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE)
	  printf(" (returnVal & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE) IS  %d\n",
			  (returnVal & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE));
	  //(flags[i+1].serialNumber & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE)
	  printf(" (returnVal & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE) IS  %d\n",
			  (returnVal & (SWAPPED|ENABLED|AVAILABLE)) == (ENABLED|AVAILABLE));

	    /* Obtém estado atual de todos os relés */
	  unsigned int MascaraReles = 0;
	  unsigned int ComandoAtuacao = 0 ;

	  printf(" (MascaraReles |= SWAPPED) IS  %d\n", returnVal);

	  unsigned long cmdAtuacao = 0;
	  //cmdAtuacao |= 1 << 2;
	  //printf(" cmdAtuacao  %d\n", cmdAtuacao);
	  unsigned char i;
	  for(i = 0; i < 12; i++)
	  {
		  if(i == 5){
			  cmdAtuacao |= 1 << i;
		  }
		  if(i == 6){
			  cmdAtuacao |= 1 << i;
		  }
		  printf(" cmdAtuacao [%d] ==  %d\n", i, cmdAtuacao);
	  }
	  cmdAtuacao = cmdAtuacao | (0x8000);
	  printf(" cmdAtuacao  %d\n", cmdAtuacao);

	  i = 0;
	  unsigned char numSlots = 12;
	  for(i = 0; i < numSlots; i++)
	  {
		  printf(" Tem UC [%d] ==  %d\n", i, cmdAtuacao & (1 << i));
	  }

}

int main(void)
{
	//testBufferCirc();
	//testSelection();
	testBinareOperations();
	return EXIT_SUCCESS;
}
