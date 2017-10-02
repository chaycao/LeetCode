/*
明亮的做法。基础102的用NULL进行隔断。然后根据层数，判断vector是否反转
*/
class Solution {
public:
	vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
		queue<TreeNode *> q;
		vector<vector<int>> zlo;

		if (root == NULL) return zlo;

		int level = 0;

		q.push(root);
        zlo.push_back(vector<int>());
		q.push(NULL);
		while (!q.empty())
		{
			TreeNode *front = q.front();
			q.pop();
			if (front == NULL) {
				if (level % 2 == 1) reverse(zlo[level].begin(),zlo[level].end());
                if(!q.empty()){
				zlo.push_back(vector<int>());
				level++;
				q.push(NULL);
                }
			}
			else {
				zlo[level].push_back(front->val);
				if(front->left!=NULL)	q.push(front->left);
				if(front->right!=NULL)	q.push(front->right);
			}
		}
        return zlo;
	}
};
