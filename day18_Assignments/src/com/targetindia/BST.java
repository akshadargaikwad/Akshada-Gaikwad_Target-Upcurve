package com.targetindia;

public class BST {

    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    Node root=null;

    public void insert(int data)
    {
        System.out.println("insering "+data+"....");
        root=insert(root,data);
        System.out.println("successfully inserted "+data);
    }

    private Node insert(Node node,int data)
    {
        if(node==null)
        {
            return new Node(data);
        }

        if(data<node.data)
        {
            node.left=insert(node.left,data);
        }
        else if(data>node.data)
        {
            node.right=insert(node.right,data);
        }
        return node;
    }

    public void display()
    {
        display(root,0);
        System.out.println();
    }

    public void display(Node node,int level)
    {
        if(node!=null)
        {
            display(node.right,level+1);
            System.out.println(" ".repeat(4*level)+node.data);
            display(node.left,level+1);
        }


    }


    public void preorder()
    {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node)
    {
        if(node!=null)
        {
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder()
    {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node)
    {
        if(node!=null)
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data+" ");
        }
    }

    public void inorder()
    {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node)
    {
        if(node!=null)
        {
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }

    public void delete(int data)
    {
        root=delete(root,data);
    }

    private Node delete(Node node,int data)
    {
        if(node==null)
        {
            return node;
        }

        if(data<node.data)
        {
            node.left=delete(node.left,data);
        }
        else if(data>node.data)
        {
            node.right=delete(node.right,data);
        }
        else{
            if(node.left==null)
            {
                return node.right;
            }
            else if(node.right==null)
            {
                return node.left;
            }

            node.data=smallest(node.right);
            node.right=delete(node.right,node.data);
        }
        return node;
    }

    private int smallest(Node node)
    {
        int data=node.data;
        var curr=node;
        while(curr.left!=null)
        {
            data=curr.left.data;
            curr=curr.left;
        }

        return data;
    }

    public int largest(Node node)
    {
        int data=node.data;
        var curr=node;
        while(curr.right!=null)
        {
            data=curr.right.data;
            curr=curr.right;
        }

        return data;
    }

    public int findSmallestValue()
    {
        return smallest(root);
    }
    public int findlargestvalue()
    {
        return largest(root);
    }

    private int finddepth(Node node,int data)
    {
        if(node==null)
        {
            return -1;
        }

        int depth=-1;

        if((node.data==data)
        || (depth=finddepth(node.left,data))>=0
        || (depth=finddepth(node.right,data))>=0)
        {
            return depth+1;
        }

        return depth;
    }

    public int findTreeLength()
    {
        return findTreeLength(root);
    }

    private int findTreeLength(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        else{
            int left_height=findTreeLength(node.left);
            int right_height=findTreeLength(node.right);
            if(left_height>=right_height)
            {
                return left_height+1;
            }
            else{
                return right_height+1;
            }
        }
    }
}

