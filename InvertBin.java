 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

 class InvertBin {
     public TreeNode invertTree(TreeNode root) {
        return recInvert(root);
     }

     public TreeNode recInvert(TreeNode root) {
        if(root == null) return null;

        return new TreeNode(root.val,
                            recInvert(root.right),
                            recInvert(root.left));
     }
 }
