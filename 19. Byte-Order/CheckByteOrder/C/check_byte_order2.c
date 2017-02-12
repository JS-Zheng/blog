#include <stdio.h>

int main() {
    int num = 0x1234ABCD;

    // 指標轉型: 將位址轉型為 指向 char
    char *ptrNum = (char *) &num;

    for (int i = 0; i < 4; i++) {
        printf("%p: %02x \n", (void *) ptrNum, (unsigned char) *ptrNum++);
    }

    return 0;
}