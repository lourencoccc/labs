/*
 * buffercircle.c
 *
 *  Created on: Feb 5, 2018
 *      Author: joao_lourenco
 */

#include "string.h"
#include "buffercirc.h"

int ald_buffer_insert(buffer_circ_t *b, void *data, unsigned int size)
{
	int result = -1;
	unsigned char *ptr = (unsigned char *) data;

	if (b == NULL)
	{
		/* check your buffer parameter */
		return (result);
	}

	if (size + b->items <= BUFFER_SIZE)
	{

		/* the buffer has enough room, insert
		 * stream.
		 */
		unsigned int i;
		for (i = 0; i < size; i++)
		{
			b->data[b->writeIndex] = *ptr++;

			/* increment the input index in form  if it
			 * reach the buffer end, its placed in it
			 * initial address again
			 */
			b->writeIndex = (b->writeIndex + 1) % BUFFER_SIZE;
			printf("Write Index = %i \n", b->writeIndex);
			b->items++;
		}
		result = 0;
	}

	return (result);
}

int adl_buffer_retrieve(buffer_circ_t *b, void *data, unsigned int size)
{
	int result = 0;
	unsigned char *ptr = (unsigned char *) data;

	if (b == NULL)
	{
		/* check your buffer parameter */
		return ((result = -1));
	}

	/* if the size requested fits on
	 * current contents, extract
	 * the data stream
	 */
	unsigned int i;
	for (i = 0; (i < size) && (b->items != 0); i++)
	{
		*ptr++ = b->data[b->readIndex];
		b->readIndex = (b->readIndex + 1) % BUFFER_SIZE;
		printf("Read Index = %i \n", b->readIndex);
		result++;
		b->items--;
	}

	return (result);
}
int adl_buffer_full(buffer_circ_t *b)
{
	int result = 0;
	if (b->items == BUFFER_SIZE)
	{
		result = 1;
	}
	return (result);
}

int adl_buffer_will_full(buffer_circ_t *b, unsigned int size)
{
	int result = 0;

	if (b->items + size > BUFFER_SIZE)
	{
		result = 1;
	}
	return (result);
}
int adl_buffer_flush(buffer_circ_t *b)
{
	int result = 0;

	if (b != NULL)
	{
		b->writeIndex = b->readIndex;
		b->items = 0;
	}
	else
	{
		result = -1;
	}

	return (result);
}
int adl_buffer_empty(buffer_circ_t *b)
{
	return ((b->items == 0 ? 1 : 0));
}

