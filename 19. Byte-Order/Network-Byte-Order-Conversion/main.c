#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <memory.h>

int main(int argc, char **argv) {

    struct sockaddr_in svaddr;

    char *address = "127.0.0.1";
    int port_num = 9527;


    /* Clear structure */
    memset(&svaddr, 0, sizeof(struct sockaddr_in));

    svaddr.sin_family = AF_INET;

    // 將 port 由 本機位元組順序 轉換為 網路位元組順序
    svaddr.sin_port = htons(port_num);

    printf("--------(1)--------\n");
    printf("欲轉換 port: %i\n", port_num);
    printf("-------Result-------\n");
    printf("htons: %i\n", svaddr.sin_port);

    printf("\n\n");

    // 將 address 由 本機位元組順序 轉換為 網路位元組順序
    if (inet_pton(AF_INET, address, &svaddr.sin_addr) <= 0) {
        printf("inet_pton failed for address %s\n", address);
        exit(EXIT_FAILURE);
    }

    printf("--------(2)--------\n");
    printf("欲轉換位址: %s\n", address);
    printf("-------Result-------\n");
    printf("inet_pton: %p\n", svaddr.sin_addr);


    return 0;


}


/*
 * Result:
 *
 * --------(1)--------
 * 欲轉換 port: 9527
 * -------Result-------
 * htons: 14117
 *
 * --------(2)--------
 * 欲轉換位址: 127.0.0.1
 * -------Result-------
 * inet_pton: 0x100007f
 */