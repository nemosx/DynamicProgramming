#include <iostream>
#include <algorithm>

int
main() {
  const int n = 7; 
  int sequence [n] = {5, 2, 8, 9, 11, 13, 12};
  int longestSubsequence [n];
  std::fill_n(longestSubsequence, n, 1);

  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < i; ++j) {
      if (sequence[j] < sequence[i] && (longestSubsequence[j] + 1) > longestSubsequence[i]) {
         longestSubsequence[i] = longestSubsequence[j] + 1; 
      }
    }
  }

  std::cout<< "Longest Subsequence: " << *std::max_element(std::begin(longestSubsequence), std::end(longestSubsequence)); 
  return 0;
}
