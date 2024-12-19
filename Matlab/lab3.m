%% 1
yprime=@(t,y)5*t+3*exp(-0.2*t)-5*y^2
[t,y] = ode45(yprime, [1 5], 5);
plot(t,y,'+');
y(end)
%% 2
x = [ 0.000 1.000 2.000 3.000 4.000 5.000 ];
y = [ 3.749 4.689 6.273 5.897 6.381 7.003 ];
plot(x,y,'+');
hold on
p=polyfit(x,y,5);
px=0:0.1:5;
py=polyval(p,px);
plot(px,py)
hold on
p=polyfit(x,y,1);
py=polyval(p,px);
plot(px,py,'b')
%% 3
x = [ 0.10 0.20 0.30 0.40 0.50 0.60 0.70 0.80 0.90 1.00 1.10 1.20 1.30 1.40 1.50 ];
y = [ 1.35 1.80 1.87 1.90 2.25 2.46 2.51 2.75 2.90 2.93 2.84 2.92 2.82 2.94 3.12 ];
plot(x,y,'-')
axis([0 1.5 1 3.5])
hold on
w=exp(y);
p=polyfit(x,w,1)
py=polyval(p,x)
a=p(2);
b=p(1);
f=@(x)log(a+b*x);
y=f(x);
plot(x,y,'m')
%% 4
v = csvread('race.txt');
size(v)
v(1)
v(450)
t = linspace(0,40,6000);
size(t)
plot(t,v)
%% 5
v = csvread('race.txt');
size(v);
v(1);
v(450);
t = linspace(0,40,6000);
size(t);
v(find(v>80)) = 0;
plot(t,v)
hold on
c = csvread('race.txt');
k=find(c>80);
c(k)=c(k-1);
plot(t,c)
%% 6
z = trapz(t,v)
%% 7
v = csvread('const_accel.txt');
s = size(v);
t = linspace(0,5,s(1));
plot(t,v)
%% 8
v = csvread('const_accel.txt');
s = size(v);
t = linspace(0,5,s(1));
plot(t,v)
hold on
p=polyfit(t,v,1);
a=p(1)
b=p(2);
f=@(t)a*t+b;
y=f(t);
plot(t,y,'-')

