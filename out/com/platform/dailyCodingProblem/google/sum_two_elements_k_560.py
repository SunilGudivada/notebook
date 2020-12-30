
# Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
#
# For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
#
# Bonus: Can you do this in one pass?

def method1(numList, requiredSum):
    dictionary = {}
    for num in numList:
        if requiredSum - num not in dictionary:
            dictionary[requiredSum - num] = 0
        if num in dictionary:
            print(num, requiredSum - num)
            return True
    return False


arr=[10, 5, 3, 7, 3]
print(method1(arr, 17))
