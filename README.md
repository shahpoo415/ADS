# ADS
Compiling Instructions:

The project has been coded in Java and can be compiled using JDK 1.8.0_60, with javac compiler.

The input text files are to be placed in the project directory before running the program. 

To compile in the Unix environment, run the following command after changing the directory to the project directory:

$ make

The encoder file should be given the command:

$ java encoder <input_file_name> 

The decoder file should be given the command:

$ java decoder <encoded_file_name> <code_table_file_name> 

Performance Analysis:
The code was tested on the sample_input_large.txt for all three data structures. The following is the time analysis of all three data data structures for one iteration:
1)	Binary Heap: 0.7232 secs.
Binary heaps have two children. Hence only two comparisons are made in every pass. So, more number of comparisons are needed to heapify the entire list. Hence the time taken is more than 4 way cache optimized heap.

2)	4 way cache optimized heap: 0.5540 secs
The nodes have 4 children. The number of levels become half than that of the binary heap. The number of comparisons done per pass are 4. For each operation, the 4 way heap goes log2 n levels down. Hence less number of comparisons are to be done with respect to the binary heap. This speeds up the code about 1.5 when sorting 1 million elements using heapsort and cache-aligned 4-heap vs. 2-heap that begins at array position 0.

3)	Pairing heap: 1.5989 secs
Pairing heap is the slowest  because for a large data set, it might be that the level below root has too many nodes and hence extract min takes linear time in the order of the number of nodes in that level. Hence compared to binary/ 4-way heap that take logarithmic time, pairing heaps are the slowest.

