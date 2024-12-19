%% Julia
colormap jet
m=complexmat(1000,-2+1.5i,2-1.5i);
% f=@(x,y)converge3(x,-0.835 - 0.2321i);
f=@(x,y)converge3(x,0.8i);
v = arrayfun(f,m);
imagesc(v)

%% Mandelbrot
colormap hot
%m=complexmat(1000,-2+i,1-i);
m=complexmat(10000,-2+i,1 - i);
f=@(x)converge2(x);
v = arrayfun(f,m);
imagesc(v)
hold on

%% Newton
colormap jet
m = complexmat(1000, -2+i, 1-i);
g = @(x)(x^2);
f=@(x)newton(g(x), x);
v = arrayfun(f, m);
imagesc(v)
hold on