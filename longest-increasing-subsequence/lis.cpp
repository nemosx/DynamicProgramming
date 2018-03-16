#include <algorithm>
#include <array>
#include <iostream>

int main() {
  auto sequence = std::array{5, 2, 8, 9, 11, 13, 12};
  decltype(sequence) longestSubsequence;
  longestSubsequence.fill(1);

  for (int i = 0; i < sequence.size(); ++i) {
    for (int j = 0; j < i; ++j) {
      if (sequence[j] < sequence[i] &&
          (longestSubsequence[j] + 1) > longestSubsequence[i]) {
        longestSubsequence[i] = longestSubsequence[j] + 1;
      }
    }
  }

  std::cout << "Longest Subsequence: "
            << *std::max_element(std::begin(longestSubsequence),
                                 std::end(longestSubsequence));
  return 0;
}
