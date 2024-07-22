#include <stdio.h>

int main(void) {
    int H, M;
	scanf("%d %d", &H, &M);

	if (0 <= H && H <= 23 && (0 <= M && M <= 59)) {
		int mm = M - 45;
		
		if (0 <= mm && mm <= 59) {
			printf("%d %d", H, mm);
		}
		else {
			int h = H - 1;
			int mm2 = 60 + mm;
			if (0 <= h && h <= 23) {
				printf("%d %d", h, mm2);
			}
			else {
				int h2 = 24 + h;
				printf("%d %d", h2, mm2);
			}
		}
	}
	else {
		printf("ERROR");
	}

	return 0;
}