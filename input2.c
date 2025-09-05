#include <stdio.h>
int max(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

int main() {
    int x = 5;
    int y = 9;
    int bigger = max(x, y);
    printf("%d\n", bigger);
    return 0;
}
