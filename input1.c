#include <stdio.h>
int main() {
    for (int i = 0; i < 3; i = i + 1) {
        printf("%d\n", i);
    }
    int j = 0;
    for (j = 0; j < 3; j = j + 1) {
        printf("%d\n", j);
    }
    return 0;
}
