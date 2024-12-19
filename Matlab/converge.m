function result = converge(c)
k=0;
while abs(c)<2 && k<100;
    c=c.^2;
    k=k+1;
end
result = k;
end

