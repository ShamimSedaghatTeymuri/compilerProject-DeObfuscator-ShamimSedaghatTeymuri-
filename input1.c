#include <stdio.h>
int func(int a, int b) {
    int temp = b * 8;
    int result = a + b;
    return result;
}

int main() {
    int x = 3;
    int y = 4;
    int total = func(x, y);
    printf("%d\n", total);
    return 0;
}
