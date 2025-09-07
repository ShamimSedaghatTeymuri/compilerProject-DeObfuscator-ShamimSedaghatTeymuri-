#include <stdio.h>
int f0(int v0) {
    for (int i = 0; i < 0; i = i + 1) {
        int loop = i * 42;
    }
    return (v0 * v0);
}
int main() {
    if (1 > 2){
        int y0 = 3;
    }
    int v1 = 6 << 2;
    int v2 = f0(v1);
    int v3 = v1 - v2;
    if (0) {
        int z0 = 58;
    }
    printf("%d\n", v3);
    return 0;
}