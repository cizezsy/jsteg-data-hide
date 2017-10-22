package me.cizezsy.huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HuffmanTable {
    private int id;
    private int type;
    private int[] eachNodeNum;
    private int[] weights;
    private List<TreeNode> treeNodes;

    public HuffmanTable(int id, int type, int[] eachNodeNum, int[] weights) {
        this.id = id;
        this.type = type;
        this.eachNodeNum = eachNodeNum;
        this.weights = weights;
        initTree();
    }

    private void initTree() {
        int[] nodeNum = Arrays.copyOf(eachNodeNum, eachNodeNum.length);
        treeNodes = new ArrayList<>();
        TreeNode currentNode = null;
        int currentNodeNumIndex = 0;
        int currentWeightIndex = 0;
        while (currentWeightIndex < weights.length) {
            if (nodeNum[currentNodeNumIndex] == 0) {
                currentNodeNumIndex++;
            } else {
                nodeNum[currentNodeNumIndex]--;
                TreeNode treeNode = new TreeNode();
                treeNode.weight = weights[currentWeightIndex++];
                treeNode.length = currentNodeNumIndex + 1;
                if (currentNode == null) {
                    treeNode.bitCode = 0;
                } else {
                    if (currentNode.length == currentNodeNumIndex + 1) {
                        treeNode.bitCode = currentNode.bitCode + 1;
                    } else {
                        int shift = currentNodeNumIndex + 1 - currentNode.length;
                        int bitCode = currentNode.bitCode + 1;
                        treeNode.bitCode = bitCode << shift;
                    }
                }
                treeNodes.add(treeNode);
                currentNode = treeNode;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int[] getEachNodeNum() {
        return eachNodeNum;
    }

    public void setEachNodeNum(int[] eachNodeNum) {
        this.eachNodeNum = eachNodeNum;
    }

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }

    private class TreeNode {
        int length;
        int bitCode;
        int weight;
    }
}