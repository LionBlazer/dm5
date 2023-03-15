% Файл: maximum_matching.mzn
include "globals.mzn";

int: n;
array[1..n, 1..n] of 0..1: adj_matrix;

array[1..n, 1..n] of var 0..1: edge_vars;

constraint forall(i in 1..n) (
sum(j in 1..n) (edge_vars[i, j] + edge_vars[j, i]) <= 1
);

constraint forall(i, j in 1..n) (
edge_vars[i, j] <= adj_matrix[i, j]
);


var int: total_edges = sum(i, j in 1..n) (edge_vars[i, j]);
solve maximize total_edges;

output [
"Maximum matching size: ", show(total_edges), "\n",
"Matching edges:\n"
] ++ [if fix(edge_vars[i, j]) == 1 then ("" ++ show(i) ++ " " ++ show(j) ++ ",\n") else "" endif | i, j in 1..n];