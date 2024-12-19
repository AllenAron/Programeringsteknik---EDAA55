%% Funktioner
f=@(x) x.^5 - 16*x.^4 + 67*x.^3 + 48*x.^2 - 684*x + 864;
x=linspace(0,5);
y=f(x);
plot(x,y)
%% Polynom
p=[1 -16 67 48 -684 864];
x=linspace(0,5);
y=polyval(p, x);
plot(x,y);
grid on
%% Polynom 2
roots(p)
q = poly([-8 -3 2 4]);
x=linspace(-5,5);
y=polyval(q,x);
plot(x,y)
grid on
%% Integraler
f = @(t)2*exp(-0.4*t)+3*cos(5*t)
S = integral(f,1.4,2.8)
x=linspace(1,3);
y=f(x);
plot(x,y);
grid on
%% Minima, maxima och nollställen
g = @(x)(cos(exp(x))./(1-x))
x=linspace(2,3);
y=g(x);
plot(x,y)
grid on
minx1=fminbnd(g,2,3)
g(minx1)
h=@(x)5.*x.^2 + 2.*x - 3.*exp(-x.^2)
minx1=fminbnd(h,-1,1);
min = h(minx1)
zero1 = fzero(h,-1)
zero2 = fzero(h,1)
x=linspace(-1,1);
y=h(x);
plot(x,y)
grid on
%% Matriser
B=5.*eye(10)
M=3*eye(10) + diag([5 5 5 5 5 5 5 5 5], 1) + diag([5 5 5 5 5 5 5 5 5], -1)
det(M)
%% Mandelbrotmängden
z=0.5
z=z.^2
z=z.^2
z=z.^2
z=z.^2
z=z.^2
z=z.^2
%% 10
m=complexmat(100,-2+i,1-i);
f=@(x)converge(x);
v = arrayfun(f,m);
imagesc(v)
%% 11
m=complexmat(10,-2+i,1-i);
f=@(x)converge(x);
v = arrayfun(f,m);
imagesc(v)
%% 12
colormap hot
m=complexmat(1000,-2+i,1-i);
%m=complexmat(10000,-0.5+0.i,0.7-0.3i);
f=@(x)converge2(x);
v = arrayfun(f,m);
imagesc(v)
hold on
%% Juliamängder
colormap jet
m=complexmat(1000,-2+1.5i,2-1.5i);
% f=@(x,y)converge3(x,-0.835 - 0.2321i);
f=@(x,y)converge3(x,0.5+i/3);
v = arrayfun(f,m);
imagesc(v)