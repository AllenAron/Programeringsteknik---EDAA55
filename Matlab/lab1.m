%% Komplexa tal
a = 3 + 2i;
b = 5 - i;
x = a * b
%% Funktioner
g=@(x)exp(-0.1*x).*cos(x);
deriv=@(f,x)(f(x+h)-f(x))/h
h=10^-6;
x=linspace(0,10);
y=g(x);
plot(x,g(x))
hold on
plot(x,deriv(g,x))
title('Funktionen och dess derivata')
legend('funktion', 'derivata')
print('funktionsbild','-dpng')
h1=@(x)exp(-0.1*x).*cos(x)-0.1.*exp(-0.1*x).*sin(x)
h2=@(x)-0.1*exp(-0.1*x).*cos(x)-exp(-0.1*x).*sin(x)
h3=@(x)-0.1*exp(-0.1*x).*cos(x)-0.1*exp(-0.1*x).*sin(x)
y0=deriv(g,x)
y1=h1(x)
y2=h2(x)
y3=h3(x)
d1=y1-y0
d2=y2-y0
d3=y3-y0
norm(d1)
norm(d2)
norm(d3)


%% Derivator
h=10^-6;
f=@(x)x^2
x=2
deriv=@(f,x)(f(x+h)-f(x))/h
deriv(f,x)
