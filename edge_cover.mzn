include "globals.mzn";

int: n;
array[1..n, 1..n] of int: adj_matrix;

set of int: Nodes = 1..n;
array[1..n, 1..n] of var 0..1: edge_cover;

constraint forall(i, j in Nodes where i < j) (
    edge_cover[i, j] = edge_cover[j, i]
);

constraint forall(i in Nodes) (
    edge_cover[i, i] = 0
);

constraint forall(i, j in Nodes where adj_matrix[i, j] = 1) (
    sum(k in Nodes) (edge_cover[i, k]) >= 1 \/ sum(k in Nodes) (edge_cover[j, k]) >= 1
);

constraint forall(i, j in Nodes where adj_matrix[i, j] = 0) (
    edge_cover[i, j] = 0
);

var int: total_edges = sum(i, j in Nodes where i < j) (edge_cover[i, j]);
solve minimize total_edges;

output ["Minimum edge cover: ", show(total_edges), "\n"];
output [ if fix(edge_cover[i,j]) == 1 then ("" ++ show(i) ++ " " ++ show(j) ++ ",\n") else "" endif | i, j in Nodes where i < j];
