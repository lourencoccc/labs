/*
 * selection.c
 *
 *  Created on: Feb 20, 2018
 *      Author: joao_lourenco
 */

#include "selection.h"

void select_med(int med, int* result)
{
	if (med & 1)
	{
		result[0] = 0;
	}
	else
	{
		result[0] = 1;
	}

	if (med & 2)
	{
		result[1] = 0;
	}
	else
	{
		result[1] = 1;
	}


	if (med & 4)
	{
		result[2] = 0;
	}
	else
	{
		result[2] = 1;
	}


	if (med & 8)
	{
		result[3] = 0;
	}
	else
	{
		result[3] = 1;
	}
}

