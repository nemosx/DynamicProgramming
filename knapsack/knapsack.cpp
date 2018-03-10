#include <iostream>
#include <algorithm>

struct Item {
  int value;
  int weight;
};

int 
main() {
  int n = 4;
  int W = 8;
 
  Item items [4] = {{4, 8}, {2, 11}, {3, 4}, {6, 1}};
  int opt[n + 1][W + 1];
  
  for (int i = 0; i <= n; ++i) {
    for (int w = 0; w <= W; ++w) {
      if (i == 0 || w == 0) {
        opt[i][w] = 0;
      }
      if (w < items[i].weight) {
        opt[i][w] = opt[i - 1][w];
      }
      else {
         opt[i][w] = std::max(items[i].value + opt[i][w - items[i].weight], opt[i - 1][w]);
      }
    }

  } 
  std::cout<<opt[n][W];
}
