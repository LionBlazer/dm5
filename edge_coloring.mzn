include "globals.mzn";

int: n;
array[1..n, 1..n] of int: adj_matrix;

int: num_colors = ceil(n / 2);

array[1..n, 1..n] of var 0..num_colors: edge_colors;

constraint forall(i, j in 1..n where adj_matrix[i, j] == 1)(
    edge_colors[i, j] > 0 /\ edge_colors[i, j] == edge_colors[j, i]
);

constraint forall(i in 1..n, k in 1..num_colors)(
    let {
        array[int] of var 0..1: adj_same_color = [
            if adj_matrix[i, j] == 1 /\ edge_colors[i, j] == k then 1 else 0 endif | j in 1..n
        ]
    } in
    sum(adj_same_color) <= 1
);

solve minimize max(edge_colors);

output [
    "Minimum edge coloring: ", show(max(edge_colors)), "\n",
    "Edge colors:\n"
]
