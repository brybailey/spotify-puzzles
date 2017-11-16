// Reverse binary 
// Takes a number as input and reverses its binary representation
// (c) 2017 Bryan C. Bailey

#include <stdio.h>
#include <stdlib.h>

int main() {

  // Number to reverse
  int in;
  scanf( "%d", &in );

  int out=0;
  int test;

  // Push numbers in one at a time backwards
  while( in != 0 ) {

    test = in&1;
    // We're going to have to push either a 0 or a 1 to out
    out = out<<1;

    // Here we push a one if we found it in 'in'
    if( (test&1) == 1 ) {
      out++;
    }
    // Continue pushing 'in' to 'out'
    in = in>>1;
  }
  printf( "%d", out );
  return 1; 
}
