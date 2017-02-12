#include <stdio.h>

int main() {
    int i = 1;
    char *c = (char *) &i;

    if (*c)
        printf("LITTLE_ENDIAN\n");
    else
        printf("BIG_ENDIAN\n");

    return 0;
}