colormap jet
m = complexmat(1000, -2+1.5i, 2-1.5i);
f = @(z)abs((sin(z)));
v = arrayfun(f, m);
imagesc(v);