#include<iostream>
#include<algorithm>

int
main() {
  const int n = 10;
  int opt[n+1] = {-1};
  opt[1] = 1;

  for (int i = 2; i <= n; ++i) {
    for (int k = 1; k < i; ++k) {
      opt[i] = std::max(opt[i], std::max(opt[k] * (i - k),k * (i - k)));
    }
  }

  std::cout<<"Opt: " << opt[n];
  return 0;
}
