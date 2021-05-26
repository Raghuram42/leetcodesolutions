impl Solution {
    pub fn mirror_reflection(p: i32, q: i32) -> i32 {
        let (mut p, mut q) = (p, q);
        while p % 2 == 0 && q % 2 == 0 {
            p >>= 1;
            q >>= 1;
        }
        if p % 2 == 0 {
            2
        } else if q % 2 == 0 {
            0
        } else {
            1
        }
    }
}