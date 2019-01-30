package Final;

public class TreeDiameter {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }
TreeNode root;
      public TreeNode createTree()
      {
          TreeNode node=new TreeNode(1);
          node.left=new TreeNode(2);
          node.right=new TreeNode(3);
          node.left.left=new TreeNode(4);
          node.left.right=new TreeNode(5);
          root=node;
          return root;
      }

        int diameter=0;

        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null) {
                return 0;
            }
            int d=getDiameter(root);
            return d;
        }

        public int getDiameter(TreeNode root) {
            if(root==null) {

                return 0;
            }
            int left = getDiameter(root.left);
            int right = getDiameter(root.right);
            if(left+right > diameter)
                diameter = left+right;
            return 1+ Math.max(left, right);
        }

    public static void main(String[] args) {
        TreeDiameter tree=new TreeDiameter();
        TreeNode root1=tree.createTree();
        int d=tree.diameterOfBinaryTree(root1);
        System.out.println("Diameter of tree: "+d);
    }
    }

