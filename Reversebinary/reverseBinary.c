// Prime finder
// (c) 2017 Bryan C. Bailey

#include <stdio.h>
#include <stdlib.h>

int main() {
  int in;
  scanf( "%d", &in );

  int out;
  int test;

  while( in != 0 ) {
    test = in&1;
    out = 1<<out;
    if( (test&1) == 1 ) {
      out++;
    }

    in = in >> 1;
  }

  printf( "%d is out\n", out );


  return 1; 

}
