//Function for print modal recipe window and window of summarizing list
//printedBlock - printed window
//function make new block from window need to print
// add to this block class .toprint and
//.noprint class to other blocks on page
//print block with class .toprint
//remove class .noprint
//delete block with class .toprint
function printBlock(printedBlock) {
    var printUnit = $(printedBlock).html();
    $('div.container').addClass('noprint');
    $('body').append('<div class="toprint">' + printUnit + '</div>');
    $(".toprint").find(".img-recipe-modal").unwrap();
    $(".toprint").find("#markers").remove();
    window.print();
    $('div.container').removeClass('noprint');
    $('.toprint').remove();
};

