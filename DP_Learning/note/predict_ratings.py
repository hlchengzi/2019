# from surprise import KNNBasic
# from surprise import Dataset
#
# # Load the movielens-100k dataset
# data = Dataset.load_builtin('ml-100k')
#
# # Retrieve the trainset.
# trainset = data.build_full_trainset()
#
# # Build an algorithm, and train it.
# algo = KNNBasic()
# algo.fit(trainset)
#
# uid = str(196)  # raw user id (as in the ratings file). They are **strings**!
# iid = str(302)  # raw item id (as in the ratings file). They are **strings**!
#
# # get a prediction for specific users and items.
# pred = algo.predict(uid, iid, r_ui=4, verbose=True)
for i in range(120):
    j=int(i/12)
    k=int((i%12))
    print( str(i)+"  "+str(j)+str(k))