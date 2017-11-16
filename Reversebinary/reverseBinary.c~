// Reverse binary 
// (c) 2017 Bryan C. Bailey

#include <stdio.h>
#include <stdlib.h>

int main() {
  int in;
  scanf( "%d", &in );

  int out=0;
  int test;

  while( in != 0 ) {
    test = in&1;
    out = out<<1;
    if( (test&1) == 1 ) {
      out++;
    }
    in = in>>1;
  }
  printf( "%d", out );

  return 1; 

}
