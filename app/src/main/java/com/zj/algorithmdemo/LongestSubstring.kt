package com.zj.algorithmdemo

class LongestSubstring {



    companion object {
        private const val demo = "abcabcefbdefsg"

        @JvmStatic fun main(args: Array<String>){
            println("Hello,world!")
            var substring = LongestSubstring()
//            var length = substring.lengthOfLongestSubstring1(demo)
//            var length = substring.lengthOfLongestSubstring2(demo)
            var length = substring.lengthOfLongestSubstring3(demo)
            println("the longest substring length is:" + length)

        }
    }

    /**
     * 简单粗暴的方法，遍历所有可能的子字符串，比较所有子字符串的长度
     * */
    fun lengthOfLongestSubstring1(s: String): Int {

        var ans = 0
        for (i in 0 until s.length) {
            var j = i+1
            for (j in (i+1) until s.length) {
                if (allUnique(i,j,s)) ans = Math.max(ans,j-i)
            }
        }


        return ans
    }


    /**
     * 窗口滑动
     *
     * */
    fun lengthOfLongestSubstring2(s: String): Int {

        var n = s.length
        var ans = 0
        var i=0
        var j=0
        var set = HashSet<Char>()

        while (i<n&&j<n) {
            if (!set.contains(s[j])) {
                set.add(s[j++])
                ans = Math.max(ans,j-i)
            }else {
                set.remove(s[i++])
            }
        }


        return ans
    }

    fun lengthOfLongestSubstring3(s: String): Int {

        var n = s.length
        var ans = 0
        var i=0
        var j=0

        var map = HashMap<Char,Int>()

        while (j<n) {

            if (map.containsKey(s[j])) {
                i = map.get(s[j])!!
            }
            ans = j-i+1
            map.put(s[j++],j)

        }



        return ans
    }

    /**
     * 检查子字符串是否有重复
     * */
    private fun allUnique(start:Int,end:Int,s: String):Boolean {

        var unique = true
        var set:HashSet<Char> = HashSet()

        for (i in 0 until end-start) {
            if (set.contains(s[i])) {
                unique = false
                break
            }
            set.add(s[i])
        }
        return unique
    }

}