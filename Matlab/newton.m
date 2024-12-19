function result = newton(p, z)
k = 0;
p = @(z)(z^2);
pd = @(z)(2*z);
while k < 10;
    z = z-p(z)/pd(z);
    k = k + 1;
end
result = k;
end

