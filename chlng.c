#include <stdio.h>

/*
** what is the output of the following program?
*/

char *fn(int i, char *s)
{
  while (i)
  {
    s++;
    i--;
  }

  return s;
}

int main(int argc, char** argv)
{
  int a = 2;
  static char c[] = "test";

  printf("%s\n", fn(a,c));

  return 0;
}
