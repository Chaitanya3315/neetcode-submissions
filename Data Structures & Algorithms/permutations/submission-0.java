class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> new_perms = new ArrayList<>();
            for(List<Integer> perm : perms){
                for(int i=0;i<=perm.size();i++){
                    List<Integer> copy = new ArrayList<>(perm);
                    copy.add(i , num);
                    new_perms.add(copy);
                }
            }
            perms = new_perms;
        }
        return perms;
    }
}
