package com.heartiger.challenges;

/*
    This problem was asked by Google.

    Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

    Design a binary tree node class with the following methods:

        is_locked, which returns whether the node is locked
        lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
        unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.

    You may augment the node to add parent pointers or any other property you would like.
    You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
    Each method should run in O(h), where h is the height of the tree.

 */
public class Problem15 {
     static class LockNode {
        boolean is_locked;
        LockNode left;
        LockNode right;
        LockNode parent;
        int locks;

        LockNode() {
        }

        LockNode(LockNode parent) {
            this.parent = parent;
            this.locks = 0;
        }

        /*
            The idea is to maintain parent lock count while locking or unlocking a node.
            So that we no longer need to traverse the children to check their status.
            Complexity would be O(h) where h is the height of the tree in worst case.

         */
        boolean lock() {
            if (notLockable())
                return false;

            this.is_locked = true;
            updateParentLocks(1);
            return true;
        }

        boolean unlock() {
            if (notLockable())
                return false;

            this.is_locked = false;
            updateParentLocks(-1);
            return true;
        }

        private void updateParentLocks(int val) {
            LockNode parent = this.parent;
            while (parent != null) {
                parent.locks += val;
                parent = parent.parent;
            }
        }

        private boolean notLockable() {
            if (this.locks > 0)
                return true;

            LockNode parent = this.parent;
            while (parent != null) {
                if (parent.is_locked) {
                    return true;
                }
                parent = parent.parent;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        LockNode node = new LockNode();
        node.left = new LockNode(node);
        node.right = new LockNode(node);
        node.left.left = new LockNode(node.left);
        node.right.right = new LockNode(node.right);
        node.left.lock();

        assert node.right.lock(): "Test 1 Failed";
        assert !node.lock(): "Test 2 Failed";
        assert !node.left.left.lock(): "Test 3 Failed";
        assert node.right.unlock(): "Test 4 Failed";
        assert node.right.right.lock(): "Test 5 Failed";
        assert node.left.unlock(): "Test 6 Failed";
        assert !node.lock(): "Test 7 Failed";
    }
}
