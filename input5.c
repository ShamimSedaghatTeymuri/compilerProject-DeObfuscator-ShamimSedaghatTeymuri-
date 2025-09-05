#include <stdio.h>
int sumToN(int n) {
    int sum = 0;
    int i = 1;
    while (i <= n) {
        if (i % 2 == 0) {
            sum = sum + i;
        }
        i = i + 1;
    }
    return sum;
}

int main() {
    int number = 10;
    int result = sumToN(number);
    printf("%d\n", result);
    return 0;
}
