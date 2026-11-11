class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs: string[]): string {
        let str = '';
        for(const s of strs){
            str = str.concat(s.length + '#' +s);
        }
        return str;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str: string): string[] {
        let strs = [];
        let i=0;
        while(i<str.length){
           let j =i;
           while(str[j] !== '#'){
                j++;
           }
           let len = Number(str.substring(i,j));
           i=j+1;
           j=i+len;
           strs.push(str.substring(i,j));
           i=j;
        }
        return strs;
    }
}
