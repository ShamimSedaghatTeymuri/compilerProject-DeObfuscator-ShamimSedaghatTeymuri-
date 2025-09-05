#include <stdio.h>
int factorial(int n) {
    int result = 1;
    int i;
    for (i = 1; i <= n; i = i + 1) {
        result = result * i;
    }
    return result;
}

int main() {
    int num = 4;
    int fact = factorial(num);
    printf("%d\n", fact);
    return 0;
}
