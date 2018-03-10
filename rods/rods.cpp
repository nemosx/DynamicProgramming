#include <iostream>
#include <algorithm>

int
main() 
{
  int costs [] = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  int n = sizeof(costs) / sizeof(costs[0]);
  std::cout << n << std::endl;
  int opt[n + 1];
  std::fill_n(opt, n + 1, -1); 
  opt[0] = 0;
 
  for (int k = 1; k <= n; k++) {
    for (int x = 0; x < k; x++) {
      opt[k] = std::max(opt[k], costs[k - x - 1] + opt[x]);
    }
  }   
  std::cout << "Max profit is: " << opt[n]; 
  return 0;
}
