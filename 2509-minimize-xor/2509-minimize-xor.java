class Solution {
  public int minimizeXor(int num1, int num2) {
    int kMaxBit = 30;
    int bits = Integer.bitCount(num2);
    if (Integer.bitCount(num1) == bits)
      return num1;

    int ans = 0;

    for (int i = kMaxBit - 1; i >= 0; --i)
      if ((num1 >> i & 1) == 1) {
        ans |= 1 << i;
        if (--bits == 0)
          return ans;
      }
    for (int i = 0; i < kMaxBit; ++i)
      if ((num1 >> i & 1) == 0) {
        ans |= 1 << i;
        if (--bits == 0)
          return ans;
      }

    return ans;
  }
}