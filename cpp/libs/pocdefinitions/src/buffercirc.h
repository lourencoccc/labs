/*
 * buffercirc.h
 *
 *  Created on: Feb 5, 2018
 *      Author: joao_lourenco
 */

#ifndef BUFFERCIRC_H_
#define BUFFERCIRC_H_

#define BUFFER_SIZE 4

/** circular buffer management structure */
typedef struct
{
	unsigned char data[BUFFER_SIZE];
	unsigned int items;
	unsigned int writeIndex;
	unsigned int readIndex;
} buffer_circ_t;

/**
 * @brief insert a stream data with size lenght to the buffer
 */
int ald_buffer_insert(buffer_circ_t *b, void *data, unsigned int size);

/**
 *  @brief retrieves a stream of dat with specified size
 */
int adl_buffer_retrieve(buffer_circ_t *b, void *data, unsigned int size);

/**
 *  @brief check if buffer is already full
 */
int adl_buffer_full(buffer_circ_t *b);

/**
 * @brief check if a data stream with specified size will full the buffer
 */
int adl_buffer_will_full(buffer_circ_t *b, unsigned int size);

/**
 * @brief makes the buffer empty
 */
int adl_buffer_flush(buffer_circ_t *b);

/**
 * @brief  check if buffer is empty
 */
int adl_buffer_empty(buffer_circ_t *b);

/** declare a initialized circular buffer */
#define CIRCULAR_BUFFER_DECLARE(name)  \
        buffer_circ_t name = {         \
          .data = {0},                 \
          .items = 0,                  \
          .writeIndex = 0,                 \
          .readIndex = 0,                 \
        }

#endif /* BUFFERCIRC_H_ */
